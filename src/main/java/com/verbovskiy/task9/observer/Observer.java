package com.verbovskiy.task9.observer;

import com.verbovskiy.task9.exception.TaskException;

import java.util.EventObject;

public interface Observer <T extends EventObject> {
    void actionPerformed(T eventObject) throws TaskException;
}
