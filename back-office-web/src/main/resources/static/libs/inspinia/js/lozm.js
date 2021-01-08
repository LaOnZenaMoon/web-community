(function (global, factory) {
    "use strict";

    if (typeof module === "object" && typeof module.exports === "object") {
        module.exports = global.document ? factory(global, true) : function (w) {
            if (!w.document) {
                throw new Error("lozm DataTable script Javascript requires a window with a document.");
            }
            return factory(w);
        }
    } else {
        factory(global);
    }
})(typeof window !== "undefined" ? window : this, function (window, noGlobal) {
    "use strict";

    var document = window.document;
    var version = "0.0.1";
    var lozm = function (selector) {
        return new lozm.func.init(selector);
    };
    var JWT_TOKEN = "jwtToken";

    lozm.func = lozm.prototype = {
        version: version
        , constructor: lozm
        , length: 0
    };

    var init = lozm.func.init = function (selector) {
        if (!selector) {
            return this;
        }

        var domList = document.querySelectorAll(selector);
        for (var i = 0; i < domList.length; i++) {
            this[i] = domList[i];
        }

        this.length = domList.length;
        return this;
    };

    //Gateway Address
    //Local
    lozm.GATEWAY_SERVER = "http://127.0.0.1:8882";

    //Prod
    // lozm.GATEWAY_SERVER = "http://10.110.60.12:8882";

    var isEmpty = lozm.func.isEmpty = function isEmpty(value) {
        return value === "" || value === null || value === undefined || typeof value === "undefined" || (typeof value === "object" && !Object.keys(value).length) || (value != null && typeof value === "object" && value.length === 0);
    };

    var isNotEmpty = lozm.func.isNotEmpty = function isNotEmpty(value) {
        return !isEmpty(value);
    };

    var movePage = lozm.func.movePage = function (_url) {
        if (isEmpty(_url) || checkJwtIsNotValid()) {
            deleteJwt();
            location.href = "/pages/sign/in";
            return;
        }

        location.href = _url;
    };

    var showLoadingBar = lozm.func.showLoadingBar = function () {
        $("#pageloader-overlay").show();
    };

    var hideLoadingBar = lozm.func.hideLoadingBar = function () {
        $("#pageloader-overlay").hide();
    };

    var receiveHttpError = lozm.func.receiveHttpError = function (xhr, status, error) {
        alertFail(error);
        console.log(xhr);
        console.log(status);
        console.log(error);
    }

    var setHttpDefault = function (options) {
        if(options !== undefined && !options.url.includes("/api/sign/in")) {
            if(checkJwtIsNotValid()) movePage();
        }

        showLoadingBar();
    }


    lozm.func.requestGet = function (options) {
        setHttpDefault();
        axios.get(options.url, options.data)
            .then(options.callback.success)
            .catch(isEmpty(options.callback.error) ? receiveHttpError : options.callback.error)
            .then(hideLoadingBar);
    };

    lozm.func.requestPost = function (options) {
        setHttpDefault();
        axios.post(options.url, options.data)
            .then(options.callback.success)
            .catch(isEmpty(options.callback.error) ? receiveHttpError : options.callback.error)
            .then(hideLoadingBar);
    };

    lozm.func.requestPut = function (options) {
        setHttpDefault();
        axios.put(options.url, options.data)
            .then(options.callback.success)
            .catch(isEmpty(options.callback.error) ? receiveHttpError : options.callback.error)
            .then(hideLoadingBar);
    };

    lozm.func.requestDelete = function (options) {
        setHttpDefault();
        axios.delete(options.url, options.data)
            .then(options.callback.success)
            .catch(isEmpty(options.callback.error) ? receiveHttpError : options.callback.error)
            .then(hideLoadingBar);
    };

    lozm.func.setDetail = function (_id, _data) {
        if (isNotEmpty(_data)) {
            for (var _idx in _data) {
                $("#" + _id + _idx).val(_data[_idx]);
            }
        }
    };

    lozm.func.changeFileLabel = function (_targetId) {
        $("#" + _targetId).change(function () {
            $("#" + _targetId).next(".custom-file-label").text(this.files[0].name);
        });
    };

    lozm.func.checkFileType = function (_targetId, _fileType) {
        var _fileName = $("#" + _targetId).next(".custom-file-label").text();
        if (_fileName.toLowerCase().indexOf(_fileType.toLowerCase()) == -1) return true;
        return false;
    };

    lozm.func.requestMultipartFormData = function (options) {
        setRequestMultipartFormData(options);
    };

    var setRequestMultipartFormData = function (options) {
        var ajaxOptions = $.extend({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "",
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
        }, options);

        ajaxOptions.data = options.data;

        requestAjax(ajaxOptions);
    };

    lozm.func.alertSuccess = function (_contents) {
        swal("Success", isEmpty(_contents) ? "" : _contents, "success");
    };

    var alertFail = lozm.func.alertFail = function (_contents) {
        swal("Error", isEmpty(_contents) ? "" : _contents, "error");
    };

    lozm.func.alertWarning = function (_contents) {
        swal("Warning", isEmpty(_contents) ? "" : _contents, "warning");
    };

    lozm.func.alertRowIsSelected = function () {
        swal("Error", "At least select one row.", "error");
    };

    lozm.func.alertRowsAreSelected = function () {
        swal("Error", "Cannot select more then one row.", "error");
    };

    lozm.func.datetimepicker = function (_id) {
        $("#" + _id).datetimepicker({
            format: 'yyyy-mm-ddThh:ii:ss',
        });
    }

    var checkJwtIsNotValid = lozm.func.checkJwtIsNotValid = function () {
        try {
            const _jwtToken = window.localStorage.getItem(JWT_TOKEN)
            const _decodedToken = jwt_decode(_jwtToken)
            const _now = Date.now().valueOf() / 1000
            if (typeof _decodedToken.exp !== 'undefined' && _decodedToken.exp < _now) {
                return true;
            }
            if (typeof _decodedToken._now !== 'undefined' && _decodedToken.nbf > _now) {
                return true;
            }
            return false;
        } catch (e) {
            console.log(e);
            return true;
        }
    }

    var getJwt = lozm.func.getJwt = function () {
        var _jwtToken = window.localStorage.getItem(JWT_TOKEN);
        return _jwtToken == null ? null : "Bearer " + _jwtToken;
    }

    lozm.func.getUserInfoFromJwt = function () {
        if (checkJwtIsNotValid()) movePage();

        return jwt_decode(getJwt());
    };

    //Insert JWT
    lozm.func.insertJwt = function (_token) {
        try {
            window.localStorage.setItem(JWT_TOKEN, _token);
            return true;
        } catch (e) {
            console.log(e);
            return false;
        }
    }

    //Delete JWT
    var deleteJwt = lozm.func.deleteJwt = function () {
        try {
            window.localStorage.removeItem(JWT_TOKEN);
            return true;
        } catch (e) {
            console.log(e);
            return false;
        }
    }

    lozm.func.signOut = function () {
        deleteJwt();
        location.href = "/pages/sign/in";
    }

    init.prototype = lozm.func;
    if (!noGlobal) {
        window.lozm = lozm;
    }

    return lozm;
});