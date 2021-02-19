import config from './config'

export const logger = {
    console (msg) {
        if (config.DEBUG) {
            console.log(msg)
        }
    },

    location_console (location, msg) {
        if (config.DEBUG) {
            console.log(location, " >> ", msg)
        }
    }
}

export const formatter =  {
    getTelFormat(telNum) {
        if (!telNum) {
            return "-"
        }

        if (telNum.length == 8) {
            return telNum.replace(/([ㅞ0-9]{4})([0-9]*)/, "$1-$2")
        }

        if (telNum.length < 8) {
            return telNum.replace(/(^02.{0}|[0-9]{3})([0-9]*)/, "$1-$2")
        }

        return telNum.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]*)([0-9]{4})/, "$1-$2-$3")
    }
}

export default {
    logger,
    formatter
}