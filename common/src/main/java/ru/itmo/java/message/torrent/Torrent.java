// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

public final class Torrent {
  private Torrent() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_RequestToTracker_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_RequestToTracker_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_ResponseFromTracker_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_ResponseFromTracker_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_RequestToClientServer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_RequestToClientServer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_ResponseFromClientServer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_ResponseFromClientServer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_FileContent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_FileContent_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_UserInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_UserInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_ListRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_ListRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_ListAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_ListAnswer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_UploadRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_UploadRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_UploadAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_UploadAnswer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_SourcesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_SourcesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_SourcesAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_SourcesAnswer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_UpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_UpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_UpdateAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_UpdateAnswer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_StatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_StatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_StatAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_StatAnswer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_GetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_GetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_GetAnswer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_GetAnswer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_itmo_java_message_torrent_FileParts_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_itmo_java_message_torrent_FileParts_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rtorrent.proto\022\034ru.itmo.java.message.to" +
      "rrent\"\236\002\n\020RequestToTracker\022@\n\013listReques" +
      "t\030\001 \001(\0132).ru.itmo.java.message.torrent.L" +
      "istRequestH\000\022=\n\006upload\030\002 \001(\0132+.ru.itmo.j" +
      "ava.message.torrent.UploadRequestH\000\022?\n\007s" +
      "ources\030\003 \001(\0132,.ru.itmo.java.message.torr" +
      "ent.SourcesRequestH\000\022=\n\006update\030\004 \001(\0132+.r" +
      "u.itmo.java.message.torrent.UpdateReques" +
      "tH\000B\t\n\007request\"\257\002\n\023ResponseFromTracker\022>" +
      "\n\nlistAnswer\030\001 \001(\0132(.ru.itmo.java.messag" +
      "e.torrent.ListAnswerH\000\022B\n\014uploadAnswer\030\002" +
      " \001(\0132*.ru.itmo.java.message.torrent.Uplo" +
      "adAnswerH\000\022D\n\rsourcesAnswer\030\003 \001(\0132+.ru.i" +
      "tmo.java.message.torrent.SourcesAnswerH\000" +
      "\022B\n\014updateAnswer\030\004 \001(\0132*.ru.itmo.java.me" +
      "ssage.torrent.UpdateAnswerH\000B\n\n\010response" +
      "\"\244\001\n\025RequestToClientServer\022@\n\013statReques" +
      "t\030\001 \001(\0132).ru.itmo.java.message.torrent.S" +
      "tatRequestH\000\022>\n\ngetRequest\030\002 \001(\0132(.ru.it" +
      "mo.java.message.torrent.GetRequestH\000B\t\n\007" +
      "request\"\244\001\n\030ResponseFromClientServer\022>\n\n" +
      "statAnswer\030\001 \001(\0132(.ru.itmo.java.message." +
      "torrent.StatAnswerH\000\022<\n\tgetAnswer\030\002 \001(\0132" +
      "\'.ru.itmo.java.message.torrent.GetAnswer" +
      "H\000B\n\n\010response\"A\n\013FileContent\022\016\n\006idFile\030" +
      "\002 \001(\003\022\020\n\010filename\030\003 \001(\t\022\020\n\010sizeFile\030\004 \001(" +
      "\003\"$\n\010UserInfo\022\n\n\002ip\030\001 \001(\t\022\014\n\004port\030\002 \001(\005\"" +
      "\r\n\013ListRequest\"L\n\nListAnswer\022>\n\013fileCont" +
      "ent\030\002 \003(\0132).ru.itmo.java.message.torrent" +
      ".FileContent\"i\n\rUploadRequest\022\020\n\010filenam" +
      "e\030\001 \001(\t\022\014\n\004size\030\002 \001(\003\0228\n\010userInfo\030\003 \001(\0132" +
      "&.ru.itmo.java.message.torrent.UserInfo\"" +
      "N\n\014UploadAnswer\022>\n\013fileContent\030\001 \001(\0132).r" +
      "u.itmo.java.message.torrent.FileContent\"" +
      " \n\016SourcesRequest\022\016\n\006idFile\030\001 \001(\003\"_\n\rSou" +
      "rcesAnswer\022>\n\016clientWithFile\030\001 \003(\0132&.ru." +
      "itmo.java.message.torrent.UserInfo\022\016\n\006id" +
      "File\030\002 \001(\003\"\245\001\n\rUpdateRequest\0228\n\010userInfo" +
      "\030\001 \001(\0132&.ru.itmo.java.message.torrent.Us" +
      "erInfo\022\032\n\022portOfClientServer\030\002 \001(\005\022>\n\013fi" +
      "leContent\030\003 \003(\0132).ru.itmo.java.message.t" +
      "orrent.FileContent\"$\n\014UpdateAnswer\022\024\n\014st" +
      "atusUpdate\030\001 \001(\010\"\035\n\013StatRequest\022\016\n\006idFil" +
      "e\030\001 \001(\003\"b\n\nStatAnswer\0226\n\006client\030\001 \001(\0132&." +
      "ru.itmo.java.message.torrent.UserInfo\022\016\n" +
      "\006idFile\030\002 \001(\003\022\014\n\004part\030\004 \003(\003\"0\n\nGetReques" +
      "t\022\016\n\006idFile\030\001 \001(\003\022\022\n\npartOfFile\030\002 \001(\003\"p\n" +
      "\tGetAnswer\022\017\n\007content\030\001 \001(\014\022>\n\013fileConte" +
      "nt\030\002 \001(\0132).ru.itmo.java.message.torrent." +
      "FileContent\022\022\n\npartOfFile\030\003 \001(\003\"i\n\tFileP" +
      "arts\0228\n\010userInfo\030\001 \001(\0132&.ru.itmo.java.me" +
      "ssage.torrent.UserInfo\022\016\n\006idFile\030\002 \001(\003\022\022" +
      "\n\npartOfFile\030\003 \001(\003B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ru_itmo_java_message_torrent_RequestToTracker_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ru_itmo_java_message_torrent_RequestToTracker_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_RequestToTracker_descriptor,
        new java.lang.String[] { "ListRequest", "Upload", "Sources", "Update", "Request", });
    internal_static_ru_itmo_java_message_torrent_ResponseFromTracker_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ru_itmo_java_message_torrent_ResponseFromTracker_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_ResponseFromTracker_descriptor,
        new java.lang.String[] { "ListAnswer", "UploadAnswer", "SourcesAnswer", "UpdateAnswer", "Response", });
    internal_static_ru_itmo_java_message_torrent_RequestToClientServer_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ru_itmo_java_message_torrent_RequestToClientServer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_RequestToClientServer_descriptor,
        new java.lang.String[] { "StatRequest", "GetRequest", "Request", });
    internal_static_ru_itmo_java_message_torrent_ResponseFromClientServer_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ru_itmo_java_message_torrent_ResponseFromClientServer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_ResponseFromClientServer_descriptor,
        new java.lang.String[] { "StatAnswer", "GetAnswer", "Response", });
    internal_static_ru_itmo_java_message_torrent_FileContent_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ru_itmo_java_message_torrent_FileContent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_FileContent_descriptor,
        new java.lang.String[] { "IdFile", "Filename", "SizeFile", });
    internal_static_ru_itmo_java_message_torrent_UserInfo_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ru_itmo_java_message_torrent_UserInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_UserInfo_descriptor,
        new java.lang.String[] { "Ip", "Port", });
    internal_static_ru_itmo_java_message_torrent_ListRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ru_itmo_java_message_torrent_ListRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_ListRequest_descriptor,
        new java.lang.String[] { });
    internal_static_ru_itmo_java_message_torrent_ListAnswer_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ru_itmo_java_message_torrent_ListAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_ListAnswer_descriptor,
        new java.lang.String[] { "FileContent", });
    internal_static_ru_itmo_java_message_torrent_UploadRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ru_itmo_java_message_torrent_UploadRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_UploadRequest_descriptor,
        new java.lang.String[] { "Filename", "Size", "UserInfo", });
    internal_static_ru_itmo_java_message_torrent_UploadAnswer_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_ru_itmo_java_message_torrent_UploadAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_UploadAnswer_descriptor,
        new java.lang.String[] { "FileContent", });
    internal_static_ru_itmo_java_message_torrent_SourcesRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ru_itmo_java_message_torrent_SourcesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_SourcesRequest_descriptor,
        new java.lang.String[] { "IdFile", });
    internal_static_ru_itmo_java_message_torrent_SourcesAnswer_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ru_itmo_java_message_torrent_SourcesAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_SourcesAnswer_descriptor,
        new java.lang.String[] { "ClientWithFile", "IdFile", });
    internal_static_ru_itmo_java_message_torrent_UpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_ru_itmo_java_message_torrent_UpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_UpdateRequest_descriptor,
        new java.lang.String[] { "UserInfo", "PortOfClientServer", "FileContent", });
    internal_static_ru_itmo_java_message_torrent_UpdateAnswer_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_ru_itmo_java_message_torrent_UpdateAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_UpdateAnswer_descriptor,
        new java.lang.String[] { "StatusUpdate", });
    internal_static_ru_itmo_java_message_torrent_StatRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_ru_itmo_java_message_torrent_StatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_StatRequest_descriptor,
        new java.lang.String[] { "IdFile", });
    internal_static_ru_itmo_java_message_torrent_StatAnswer_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_ru_itmo_java_message_torrent_StatAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_StatAnswer_descriptor,
        new java.lang.String[] { "Client", "IdFile", "Part", });
    internal_static_ru_itmo_java_message_torrent_GetRequest_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_ru_itmo_java_message_torrent_GetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_GetRequest_descriptor,
        new java.lang.String[] { "IdFile", "PartOfFile", });
    internal_static_ru_itmo_java_message_torrent_GetAnswer_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_ru_itmo_java_message_torrent_GetAnswer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_GetAnswer_descriptor,
        new java.lang.String[] { "Content", "FileContent", "PartOfFile", });
    internal_static_ru_itmo_java_message_torrent_FileParts_descriptor =
      getDescriptor().getMessageTypes().get(18);
    internal_static_ru_itmo_java_message_torrent_FileParts_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_itmo_java_message_torrent_FileParts_descriptor,
        new java.lang.String[] { "UserInfo", "IdFile", "PartOfFile", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
