// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

public interface ResponseFromTrackerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ru.itmo.java.message.torrent.ResponseFromTracker)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ru.itmo.java.message.torrent.ListAnswer listAnswer = 1;</code>
   * @return Whether the listAnswer field is set.
   */
  boolean hasListAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.ListAnswer listAnswer = 1;</code>
   * @return The listAnswer.
   */
  ru.itmo.java.message.torrent.ListAnswer getListAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.ListAnswer listAnswer = 1;</code>
   */
  ru.itmo.java.message.torrent.ListAnswerOrBuilder getListAnswerOrBuilder();

  /**
   * <code>.ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 2;</code>
   * @return Whether the uploadAnswer field is set.
   */
  boolean hasUploadAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 2;</code>
   * @return The uploadAnswer.
   */
  ru.itmo.java.message.torrent.UploadAnswer getUploadAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 2;</code>
   */
  ru.itmo.java.message.torrent.UploadAnswerOrBuilder getUploadAnswerOrBuilder();

  /**
   * <code>.ru.itmo.java.message.torrent.SourcesAnswer sourcesAnswer = 3;</code>
   * @return Whether the sourcesAnswer field is set.
   */
  boolean hasSourcesAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.SourcesAnswer sourcesAnswer = 3;</code>
   * @return The sourcesAnswer.
   */
  ru.itmo.java.message.torrent.SourcesAnswer getSourcesAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.SourcesAnswer sourcesAnswer = 3;</code>
   */
  ru.itmo.java.message.torrent.SourcesAnswerOrBuilder getSourcesAnswerOrBuilder();

  /**
   * <code>.ru.itmo.java.message.torrent.UpdateAnswer updateAnswer = 4;</code>
   * @return Whether the updateAnswer field is set.
   */
  boolean hasUpdateAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.UpdateAnswer updateAnswer = 4;</code>
   * @return The updateAnswer.
   */
  ru.itmo.java.message.torrent.UpdateAnswer getUpdateAnswer();
  /**
   * <code>.ru.itmo.java.message.torrent.UpdateAnswer updateAnswer = 4;</code>
   */
  ru.itmo.java.message.torrent.UpdateAnswerOrBuilder getUpdateAnswerOrBuilder();

  public ru.itmo.java.message.torrent.ResponseFromTracker.ResponseCase getResponseCase();
}
