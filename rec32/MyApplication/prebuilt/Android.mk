LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := JniLibName
LOCAL_SRC_FILES := libJniLibName.so
include $(PREBUILT_SHARED_LIBRARY)
LOCAL_SHARED_LIBRARIES := JniLibName
include $(LOCAL_PATH)/prebuilt/Android.mk