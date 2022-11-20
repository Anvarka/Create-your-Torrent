//package ru.itmo.java.tracker;
//
//import ru.itmo.java.message.torrent.*;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.logging.Logger;
//
//public class RequestTrackerExecutor {
//    static Logger logger = Logger.getLogger(RequestTrackerExecutor.class.getName());
//
//    public static BaseResponse answerRequest(InputStream inputStream) throws IOException {
//        BaseRequest baseRequest = BaseRequest.parseDelimitedFrom(inputStream);
//        BaseResponse.Builder baseResponseBuilder = BaseResponse.newBuilder();
//
//        switch (baseRequest.getRequestCase()) {
//            case LISTREQUEST -> {
//                return baseResponseBuilder.setListAnswer(handle(baseRequest.getListRequest())).build();
//            }
//            case UPLOAD -> {
//                return baseResponseBuilder.setUploadAnswer(handle(baseRequest.getUpload())).build();
//            }
//            case SOURCES -> {
//                return baseResponseBuilder.setSourcesAnswer(handle(baseRequest.getSources())).build();
//            }
//            case UPDATE -> {
//                return baseResponseBuilder.setUpdateAnswer(handle(baseRequest.getUpdate(), clientInfo)).build();
//            }
//            default -> throw new IOException();
//        }
//    }
//
//    public static ListAnswer handle(ListRequest request) {
//        logger.info("Request: Client want to get list files");
//        List<FileContent> files = keeperInformation.getListOfFileContent();
//        return ListAnswer.newBuilder()
//                .setCountFile(files.size())
//                .addAllFileContent(files)
//                .build();
//    }
//
//    public static UploadAnswer handle(Upload request) {
//        logger.info("Get UploadRequest");
//        FileInfo fileInfo = keeperInformation.uploadFile(request);
//        return UploadAnswer.newBuilder()
//                .setIdFile(fileInfo.fileId)
//                .setFilename(request.getFilename())
//                .setSize(fileInfo.size)
//                .build();
//    }
//
//    public static SourcesAnswer handle(Sources request) {
//        logger.info("Get SourcesRequest");
//        List<ClientIpAndPort> relevantIdFiles = keeperInformation.sources(request);
//        return SourcesAnswer.newBuilder()
//                .addAllClientWithFile(relevantIdFiles)
//                .setSizeRes(relevantIdFiles.size())
//                .build();
//    }
//
//    public static UpdateAnswer handle(Update request, ClientInfo clientInfo) {
////        logger.info("Get UpdateRequest");
//        boolean status = keeperInformation.updateInfo(request, clientInfo);
//        return UpdateAnswer.newBuilder()
//                .setStatusUpdate(status)
//                .build();
//    }
//}
