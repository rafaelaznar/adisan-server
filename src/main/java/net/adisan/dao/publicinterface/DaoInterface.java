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
package net.adisan.dao.publicinterface;

import net.adisan.bean.genericimplementation.GenericBeanImplementation;
import net.adisan.bean.helper.FilterBeanHelper;
import net.adisan.bean.helper.MetaBeanHelper;
import net.adisan.bean.meta.helper.MetaObjectGenericBeanHelper;
import net.adisan.bean.meta.helper.MetaPropertyGenericBeanHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import net.adisan.bean.helper.PListBeanHelper;

public interface DaoInterface {

    public MetaObjectGenericBeanHelper getObjectMetaData() throws Exception;

    public MetaObjectGenericBeanHelper getObjectMetaData(String ob) throws Exception; //only for statistics (different bean)

    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData() throws Exception;

    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData(String ob) throws Exception; //only for statistics (different bean)

    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception;

    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception;
    
    public PListBeanHelper getPList(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception;

    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception;

    public Long getCountX(int id_foreign, String ob_foreign, ArrayList<FilterBeanHelper> alFilter) throws Exception;
    
    public PListBeanHelper getPListX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception;

    public boolean canCreateObject() throws Exception;

    public boolean canCreate(GenericBeanImplementation oBean) throws Exception;

    public boolean canUpdate(GenericBeanImplementation oBean) throws Exception;

    public boolean canDelete(GenericBeanImplementation oBean) throws Exception;

    public boolean canStatistics(GenericBeanImplementation oBean) throws Exception;

    public MetaBeanHelper get(int id, int intExpand) throws Exception;

    public Integer create(GenericBeanImplementation oBean) throws Exception;

    public Integer update(GenericBeanImplementation oBean) throws Exception;

    public Integer delete(GenericBeanImplementation oBean) throws Exception;

    public MetaBeanHelper getStatistics(int id) throws Exception;
}
