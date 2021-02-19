import axios from 'axios';

const config = {
  baseUrl: 'http://127.0.0.1:8882'
};

function signIn(data) {
  return axios.post(`${config.baseUrl}/auth-api/api/sign/in`, data);
}

export {
  signIn,
}
