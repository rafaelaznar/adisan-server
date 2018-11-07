/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * ADISAN: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/adisan
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
package net.adisan.bean.meta.helper;

import com.google.gson.annotations.Expose;
import net.adisan.helper.EnumHelper;

public class MetaObjectGenericBeanHelper {

    private String ClassName = "";
    @Expose
    private String Icon = "";
    @Expose
    private String SingularDescription = "";
    @Expose
    private String PluralDescription = "";
    @Expose
    private EnumHelper.SourceType Type = EnumHelper.SourceType.Table;
    @Expose
    private String TableName = "";

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String CName) {
        this.ClassName = CName;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    public String getSingularDescription() {
        return SingularDescription;
    }

    public void setSingularDescription(String SingularDescription) {
        this.SingularDescription = SingularDescription;
    }

    public String getPluralDescription() {
        return PluralDescription;
    }

    public void setPluralDescription(String PluralDescription) {
        this.PluralDescription = PluralDescription;
    }

    public EnumHelper.SourceType getType() {
        return Type;
    }

    public void setType(EnumHelper.SourceType Type) {
        this.Type = Type;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

}
