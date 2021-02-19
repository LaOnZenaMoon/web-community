import axios from "axios";

axios.defaults.headers = {'Content-Type': 'application/json;charset=UTF-8'};
axios.interceptors.request.use((config) => {
    console.log('==== Intercept request ====');
    console.log(config);
    console.log('============================');
    return config;
  },
  (error) => {
    console.log(error);
    return Promise.reject(error);
  });

axios.interceptors.response.use((config) => {
    console.log('==== Intercept response ====');
    console.log(config);
    console.log('============================');
    return config;
  },
  (error => {
    console.log(error);
    return Promise.reject(error);
  }));

const config = {
  domain: 'http://127.0.0.1:8882' // local
};

const request = {
  get(path, payload) {
    if (payload) {
      return axios.get(`${config.domain + path}`, payload);
    }
    return axios.get(`${config.domain + path}`);
  },
  post(path, payload) {
    return axios.post(`${config.domain + path}`, payload);
  },
  put(path, payload) {
    return axios.put(`${config.domain + path}`, payload);
  },
  delete(path) {
    return axios.delete(`${config.domain + path}`);
  },
};

const authentication = {
  get(path, payload) {
    return request.get(path, payload);
  },
  post(path, payload) {
    return request.post(path, payload);
  },
  put(path, payload) {
    return request.put(path, payload);
  },
  delete(path) {
    return request.delete(path);
  },
};

const noAuthentication = {
  signIn(payload) {
    return request.post('/auth-api/api/sign/in', payload);
  },
};

export {
  authentication,
  noAuthentication,
}
