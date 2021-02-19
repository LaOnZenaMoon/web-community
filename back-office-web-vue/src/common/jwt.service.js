import jwt_decode from 'jwt-decode'
import { logger } from './utils'

const MODULE_NAME = "jwt.service.js"
const ID_TOKEN_KEY = "ktis_114_id_token";

export const getToken = () => {
  try {
    const jwtToken = window.localStorage.getItem(ID_TOKEN_KEY)
    const decodedToken = jwt_decode(jwtToken)
    const now = Date.now().valueOf() / 1000
    if (typeof decodedToken.exp !== 'undefined' && decodedToken.exp < now) {
      return null
    }
    if (typeof decodedToken.nbf !== 'undefined' && decodedToken.nbf > now) {
      return null
    }
    return jwtToken
  } catch (e) {
    logger.location_console(MODULE_NAME, e)
  }
  return null
};

export const getUserId = () => {
  let token = window.localStorage.getItem(ID_TOKEN_KEY);
  return jwt_decode(token).sub;
}

export const getUserName = () => {
  let token = window.localStorage.getItem(ID_TOKEN_KEY);
  return jwt_decode(token).name;
}

export const getUserDept = () => {
  let token = window.localStorage.getItem(ID_TOKEN_KEY);
  return jwt_decode(token).dept;
}

export const getUserIdx = () => {
  let token = window.localStorage.getItem(ID_TOKEN_KEY);
  return jwt_decode(token).id;
}

export const getUserRole = () => {
  let token = window.localStorage.getItem(ID_TOKEN_KEY);
  return jwt_decode(token).role;
}

export const saveToken = token => {
  logger.location_console(jwt_decode(token))
  window.localStorage.setItem(ID_TOKEN_KEY, token);
};

export const destroyToken = () => {
  window.localStorage.removeItem(ID_TOKEN_KEY);
};

export default { getToken, saveToken, destroyToken, getUserId, getUserRole };
