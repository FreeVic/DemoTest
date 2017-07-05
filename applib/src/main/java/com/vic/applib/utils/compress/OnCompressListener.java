package com.vic.applib.utils.compress;

public interface OnCompressListener<T> {

  /**
   * Fired when the compression is started, override to handle in your own code
   */
  void onStart();

  /**
   * Fired when a compression returns successfully, override to handle in your own code
   */
  void onSuccess(T t);

  /**
   * Fired when a compression fails to complete, override to handle in your own code
   */
  void onError(Throwable e);
}
