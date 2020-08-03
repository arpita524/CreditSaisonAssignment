package com.threesum.assignment.controller;

class Response {
    private String statusMessage;
    private String statusCode;

    public Response(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}