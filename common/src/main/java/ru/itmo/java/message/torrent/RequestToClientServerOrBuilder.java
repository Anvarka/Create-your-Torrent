// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

public interface RequestToClientServerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.itmo.java.message.torrent.RequestToClientServer)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
   * @return Whether the statRequest field is set.
   */
  boolean hasStatRequest();
  /**
   * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
   * @return The statRequest.
   */
  ru.itmo.java.message.torrent.StatRequest getStatRequest();
  /**
   * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
   */
  ru.itmo.java.message.torrent.StatRequestOrBuilder getStatRequestOrBuilder();

  /**
   * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
   * @return Whether the getRequest field is set.
   */
  boolean hasGetRequest();
  /**
   * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
   * @return The getRequest.
   */
  ru.itmo.java.message.torrent.GetRequest getGetRequest();
  /**
   * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
   */
  ru.itmo.java.message.torrent.GetRequestOrBuilder getGetRequestOrBuilder();

  public ru.itmo.java.message.torrent.RequestToClientServer.RequestCase getRequestCase();
}
