package com.psspl.model;

import java.util.List;

/**
 * Created by haresh
 * on 30-10-2018.
 */

public class SubmitJobEntity {


    /**
     * success : true
     * request : {"time":"0","params":{"printerid":["76e08157-57ac-1e2b-95ae-bb5987d716c1"],"title":["Test By Sales App"],"contentType":["application/pdf"]},"user":"pssplmobileteam@gmail.com","users":["pssplmobileteam@gmail.com"]}
     * xsrf_token : AIp06DjYNgpjQEeXzzGw8UXfk1ucfNGfzA:1540896848269
     * message : Print job added.
     * job : {"ticketUrl":"https://www.google.com/cloudprint/ticket?jobid=624df914-2a02-e2c0-d2d3-04e3e1d9a88a","printerName":"","errorCode":"","updateTime":"1540896849025","title":"Test By Sales App","message":"","ownerId":"pssplmobileteam@gmail.com","tags":["^own"],"uiState":{"summary":"QUEUED","progress":"Delivery attempts: 1"},"numberOfPages":0,"createTime":"1540896848323","semanticState":{"delivery_attempts":1,"state":{"type":"QUEUED"},"version":"1.0"},"printerid":"76e08157-57ac-1e2b-95ae-bb5987d716c1","fileUrl":"https://www.google.com/cloudprint/download?id=624df914-2a02-e2c0-d2d3-04e3e1d9a88a","id":"624df914-2a02-e2c0-d2d3-04e3e1d9a88a","rasterUrl":"https://www.google.com/cloudprint/download?id=624df914-2a02-e2c0-d2d3-04e3e1d9a88a&forcepwg=1","contentType":"application/pdf","status":"QUEUED"}
     */

    private boolean success;
    private RequestBean request;
    private String xsrf_token;
    private String message;
    private JobBean job;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public RequestBean getRequest() {
        return request;
    }

    public void setRequest(RequestBean request) {
        this.request = request;
    }

    public String getXsrf_token() {
        return xsrf_token;
    }

    public void setXsrf_token(String xsrf_token) {
        this.xsrf_token = xsrf_token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JobBean getJob() {
        return job;
    }

    public void setJob(JobBean job) {
        this.job = job;
    }

    public static class RequestBean {
        /**
         * time : 0
         * params : {"printerid":["76e08157-57ac-1e2b-95ae-bb5987d716c1"],"title":["Test By Sales App"],"contentType":["application/pdf"]}
         * user : pssplmobileteam@gmail.com
         * users : ["pssplmobileteam@gmail.com"]
         */

        private String time;
        private ParamsBean params;
        private String user;
        private List<String> users;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public List<String> getUsers() {
            return users;
        }

        public void setUsers(List<String> users) {
            this.users = users;
        }

        public static class ParamsBean {
            private List<String> printerid;
            private List<String> title;
            private List<String> contentType;

            public List<String> getPrinterid() {
                return printerid;
            }

            public void setPrinterid(List<String> printerid) {
                this.printerid = printerid;
            }

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }

            public List<String> getContentType() {
                return contentType;
            }

            public void setContentType(List<String> contentType) {
                this.contentType = contentType;
            }
        }
    }

    public static class JobBean {
        /**
         * ticketUrl : https://www.google.com/cloudprint/ticket?jobid=624df914-2a02-e2c0-d2d3-04e3e1d9a88a
         * printerName :
         * errorCode :
         * updateTime : 1540896849025
         * title : Test By Sales App
         * message :
         * ownerId : pssplmobileteam@gmail.com
         * tags : ["^own"]
         * uiState : {"summary":"QUEUED","progress":"Delivery attempts: 1"}
         * numberOfPages : 0
         * createTime : 1540896848323
         * semanticState : {"delivery_attempts":1,"state":{"type":"QUEUED"},"version":"1.0"}
         * printerid : 76e08157-57ac-1e2b-95ae-bb5987d716c1
         * fileUrl : https://www.google.com/cloudprint/download?id=624df914-2a02-e2c0-d2d3-04e3e1d9a88a
         * id : 624df914-2a02-e2c0-d2d3-04e3e1d9a88a
         * rasterUrl : https://www.google.com/cloudprint/download?id=624df914-2a02-e2c0-d2d3-04e3e1d9a88a&forcepwg=1
         * contentType : application/pdf
         * status : QUEUED
         */

        private String ticketUrl;
        private String printerName;
        private String errorCode;
        private String updateTime;
        private String title;
        private String message;
        private String ownerId;
        private UiStateBean uiState;
        private int numberOfPages;
        private String createTime;
        private SemanticStateBean semanticState;
        private String printerid;
        private String fileUrl;
        private String id;
        private String rasterUrl;
        private String contentType;
        private String status;
        private List<String> tags;

        public String getTicketUrl() {
            return ticketUrl;
        }

        public void setTicketUrl(String ticketUrl) {
            this.ticketUrl = ticketUrl;
        }

        public String getPrinterName() {
            return printerName;
        }

        public void setPrinterName(String printerName) {
            this.printerName = printerName;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        public UiStateBean getUiState() {
            return uiState;
        }

        public void setUiState(UiStateBean uiState) {
            this.uiState = uiState;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public void setNumberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public SemanticStateBean getSemanticState() {
            return semanticState;
        }

        public void setSemanticState(SemanticStateBean semanticState) {
            this.semanticState = semanticState;
        }

        public String getPrinterid() {
            return printerid;
        }

        public void setPrinterid(String printerid) {
            this.printerid = printerid;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRasterUrl() {
            return rasterUrl;
        }

        public void setRasterUrl(String rasterUrl) {
            this.rasterUrl = rasterUrl;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class UiStateBean {
            /**
             * summary : QUEUED
             * progress : Delivery attempts: 1
             */

            private String summary;
            private String progress;

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getProgress() {
                return progress;
            }

            public void setProgress(String progress) {
                this.progress = progress;
            }
        }

        public static class SemanticStateBean {
            /**
             * delivery_attempts : 1
             * state : {"type":"QUEUED"}
             * version : 1.0
             */

            private int delivery_attempts;
            private StateBean state;
            private String version;

            public int getDelivery_attempts() {
                return delivery_attempts;
            }

            public void setDelivery_attempts(int delivery_attempts) {
                this.delivery_attempts = delivery_attempts;
            }

            public StateBean getState() {
                return state;
            }

            public void setState(StateBean state) {
                this.state = state;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public static class StateBean {
                /**
                 * type : QUEUED
                 */

                private String type;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }
        }
    }
}
