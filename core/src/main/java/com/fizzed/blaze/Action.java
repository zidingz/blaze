/*
 * Copyright 2015 Fizzed, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fizzed.blaze;

/**
 *
 * @author joelauer
 * @param <T>
 */
public abstract class Action<T> {
    
    final protected Context context;
    protected volatile boolean ran;
    
    public Action(Context context) {
        this.context = context;
    }
    
    public T run() throws BlazeException {
        if (ran) {
            throw new BlazeException("Cannot run more than once");
        }
        T value = doRun();
        ran = true;
        return value;
    }
    
    abstract public T doRun() throws BlazeException;
    
    /**
    public T get() throws BlazeException, NoSuchElementException {
        if (!ran) {
            run();
        }
    }
    */
    
}
