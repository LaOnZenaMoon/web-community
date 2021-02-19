import axios from "axios";

axios.defaults.headers = {'Content-Type': 'application/json;charset=UTF-8'};
axios.interceptors.request.use((config) => {
    console.log('intercept request');
    console.log(config);
    return config;
  },
  (error) => {
    console.log(error);
    return Promise.reject(error);
  });

const config = {
  domain: 'http://127.0.0.1:8882'
};

export const request = {
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

  },
  post(path, payload) {
  },
  put(path, payload) {
  },
  delete(path) {
  },
};

const noAuthentication = {
  get(path, payload) {
  },
  post(path, payload) {
  },
  put(path, payload) {
  },
  delete(path) {
  },
};
