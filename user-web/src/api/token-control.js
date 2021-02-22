import jwtDecode from "jwt-decode";
import {superLogger} from "@/common/logger";

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

const checkTokenExpired = () => {
  try {
    const decodedToken = jwtDecode(getToken());
    if (decodedToken && typeof decodedToken.exp !== 'undefined') {
      return validateToken(decodedToken.exp);
    }

    throw `${TOKEN_KEY} is undefined.`;
  } catch (e) {
    superLogger(e);
    return false;
  }
};

const validateToken = (expirationTime) => {
  const now = Date.now().valueOf() / 1000;
  if (now > expirationTime) {
    return false;
  }

  return true;
};

export {
  getToken,
  setToken,
  removeToken,
  getUserId,
  getUserName,
  getIssueTime,
  getExpirationTime,
  checkTokenExpired,
}
