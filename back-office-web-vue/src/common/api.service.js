import axios from "axios";
import { API_URL, SMS_URL, SMS_SERVICE_URL } from "./environment";
import router from '../router'
import { destroyToken } from './jwt.service'
import {logger} from "./utils";

axios.interceptors.response.use (
    (resp) => {
        let v = resp.headers [ 'vers'] || 'default'
        if (v !== localStorage.getItem ( 'vers') && resp.config.method === 'get') {
            localStorage.setItem ('vers', v)
            window.location.reload () // 새 버전의 경우 모든 get에서 새로 고침
        }
        return Promise.resolve (resp)
})

const MODULE_NAME = "api.service.js"
const Unauthorized = 401
const onUnauthorized = () => {
    alert('로그인 정보 만료.')
    destroyToken()
    router.push(`/login?returnPath=${encodeURIComponent(location.pathname)}`)
}

const domain = API_URL
const smsDomain = SMS_URL
const smsServiceDomain = SMS_SERVICE_URL
const request = {
    get(path, payload) {
        if (payload) {
            return axios.get(`${domain + path}`, {params: payload})
                .catch(({response}) => {
                    if (response.status === Unauthorized) {
                        return onUnauthorized()
                    }
                    throw Error(response)
                })
        }

        return axios.get(`${domain + path}`)
            .catch(({response}) => {
                if (response.status === Unauthorized) {
                    return onUnauthorized()
                }
                throw Error(response)
            })
    },
    post(path, data) {
        return axios.post(`${domain + path}`, null, data)
    },
    delete(path) {
        return axios.delete(`${domain + path}`)
    },
    put(path, data) {
        return axios.put(`${domain + path}`, null, data)
    },
    getExcel(path, payload, fileName) {
        return axios.get(`${domain + path}`, {params: payload, responseType: 'blob'})
            .then(response => {
                if (window.navigator.msSaveOrOpenBlob) { // IE 10+
                    let blob = new Blob([response.data])
                    window.navigator.msSaveOrOpenBlob(blob, fileName);
                } else { // not IE
                    const url = window.URL.createObjectURL(new Blob([response.data], { type: response.headers['content-type'] }))
                    const link = document.createElement('a');
                    link.href = url
                    link.setAttribute('download', fileName)
                    document.body.appendChild(link)
                    link.click()
                }
            })
            .catch(({response}) => {
                if (response.status === Unauthorized) {
                    return onUnauthorized()
                }
                throw Error(response)
            })
    }
}

const requestSms = {
    post(path, data) {
        return axios.post(`${smsDomain + path}`, null, data)
    },
}

const requestSmsService = {
    post(path, data) {
        return axios.post(`${smsServiceDomain + path}`, null, data)
    },
}

export const setAuthInHeader = token => {
    axios.defaults.headers.common['Authorization'] = token ? `Bearer ${token}` : null;
}

export const auth = {
    login(userId, userPassword) {
        return request.post('/user/login', {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: {userId, userPassword}})
            .then(({data}) => data)
    },

    changePassword(payload) {
        return request.put('/user/password', {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: payload})
            .then(({data}) => data)
    },

    addNewUser(payload) {
        return request.post('/user', {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: payload})
            .then(({data}) => data)
    }
}

export const common = {
    fetch(url, payload) {
        logger.location_console(MODULE_NAME, "url: "+ url)
        return request.get(url, payload).catch(error => {
            throw new Error(`[RWV] callback ${error}`);
        });
    },
    create (url, item) {
        return request.post(url, {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: item})
            .then(({data}) => data)
            .catch(error => {
                alert("생성 실패: " + error.response.data.message)
                logger.location_console(MODULE_NAME, error.response)
                throw new Error(`[RWV] callback ${error.response.data.message}`);
            });
    },
    update(url, id, item) {
        return request.put(`${url + id}`, {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: item})
            .catch(error => {
                alert("수정 실패: " + error.response.data.message)
                logger.location_console(MODULE_NAME, error.response)
                throw new Error(`[RWV] callback ${error.response.data.message}`);
            });
    },
    destroy(url, id) {
        return request.delete(`${url + id}`)
            .then(({data}) => data)
            .catch(error => {
                alert("삭제 실패: " + error.response.data.message)
                logger.location_console(MODULE_NAME, error.response)
                throw new Error(`[RWV] callback ${error.response.data.message}`);
            });
    },
    excelDownloadGet(url, payload, fileName) {
        if (fileName === undefined || fileName === "") {
            fileName = new Date().toISOString().substr(0, 10) + '.xlsx';
        } else {
            fileName += '.xlsx'
        }
        return request.getExcel(url, payload, fileName)
    },
}

export const sms = {
    sendSms(url, item) {
        return requestSms.post(url, {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: item})
            .then(({data}) => data)
            .catch(error => {
                alert("실패: " + error.response.data.message)
                logger.location_console(MODULE_NAME, error.response)
                throw new Error(`[RWV] callback ${error.response.data.message}`);
            });
    },
}

export const smsService = {
    sendTelNumTest(url, item) {
        return requestSmsService.post(url, {headers: {'Content-Type': 'application/json;charset=UTF-8'}, data: item})
            .then(() => alert('발송 완료'))
            .catch(error => {
                alert("실패: " + error.response.data.message)
                logger.location_console(MODULE_NAME, error.response)
                throw new Error(`[RWV] callback ${error.response.data.message}`);
            });
    }
}
