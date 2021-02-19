import {ENV_PROD, CURRENT_ENV} from "@/common/environment";

const basicLogger = (data) => {
  if (CURRENT_ENV !== ENV_PROD) {
    console.log(data);
  }
};

const superLogger = (data) => {
  console.log(data);
};

export {
  basicLogger,
  superLogger,
}
