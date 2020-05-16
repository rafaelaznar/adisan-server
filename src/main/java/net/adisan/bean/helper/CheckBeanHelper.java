/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * ADISAN: Free Open Source Health Management System
 *
 *
 * Sources at:                https://github.com/rafaelaznar/adisan
 *                            
 * Database at:               https://github.com/rafaelaznar/adisan-database
 *
 * ADISAN is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.adisan.bean.helper;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashMap;
import net.adisan.bean.meta.helper.MetaObjectGenericBeanHelper;

public class CheckBeanHelper {
    @Expose
    private ArrayList<String> crumbs;
    @Expose
    private MetaBeanHelper user;
    @Expose
    private HashMap<String, MetaObjectGenericBeanHelper> meta;

    public CheckBeanHelper() {
    }

    public CheckBeanHelper(ArrayList<String> crumbs, MetaBeanHelper user, HashMap<String, MetaObjectGenericBeanHelper> hmMeta) {
        this.crumbs = crumbs;
        this.user = user;
        this.meta = hmMeta;
    }

    public ArrayList<String> getCrumbs() {
        return crumbs;
    }

    public void setCrumbs(ArrayList<String> crumbs) {
        this.crumbs = crumbs;
    }

    public MetaBeanHelper getUser() {
        return user;
    }

    public void setUser(MetaBeanHelper user) {
        this.user = user;
    }

    public HashMap<String, MetaObjectGenericBeanHelper> getHmMeta() {
        return meta;
    }

    public void setHmMeta(HashMap<String, MetaObjectGenericBeanHelper> hmMeta) {
        this.meta = hmMeta;
    }

}
