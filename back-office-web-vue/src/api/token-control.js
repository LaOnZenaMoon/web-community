import jwtDecode from "jwt-decode";

const TOKEN_KEY = 'LOZM_WEB_TOKEN';

const getToken = () => {
  return window.localStorage.getItem(TOKEN_KEY);
};

const setToken = (value) => {
  window.localStorage.setItem(TOKEN_KEY, value);
};

const removeToken = () => {
  window.localStorage.removeItem(TOKEN_KEY);
};

const getUserId = () => jwtDecode(getToken()).sub;

const getUserName = () => jwtDecode(getToken()).name;

const getIssueTime = () => jwtDecode(getToken()).iat;

const getExpirationTime = () => jwtDecode(getToken()).exp;


export {
  getToken,
  setToken,
  removeToken,
  getUserId,
  getUserName,
  getIssueTime,
  getExpirationTime,
}
