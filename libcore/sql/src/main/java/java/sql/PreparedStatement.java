/* 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.sql;

import java.util.Calendar;
import java.net.URL;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;

/**
 * An interface for a Precompiled SQL Statement.
 * <p>
 * An SQL Statement is put into a PreparedStatement and is precompiled so that
 * it can be executed multiple times efficiently.
 * <p>
 * Setter methods are supplied in the PreparedStatement interface for the
 * setting of IN parameters for the Statement. The setter method used for each
 * IN parameter must match the type of the IN parameter being set.
 */
public interface PreparedStatement extends Statement {

    /**
     * Add a set of parameters to the PreparedStatement's command batch.
     * 
     * @throws SQLException
     *             if a database error happens
     */
    public void addBatch() throws SQLException;

    /**
     * Clear the current parameter values.
     * <p>
     * Typically, parameter values are retained for multiple executions of the
     * Statement. Setting a parameter value replaces the previous value. This
     * method clears the values for all parameters, releasing all resources used
     * by those parameters.
     * 
     * @throws SQLException
     *             if a database error happens
     */
    public void clearParameters() throws SQLException;

    /**
     * Executes the SQL statement in this PreparedStatement.
     * <p>
     * A PreparedStatement may return multiple results. The execute method
     * returns a flag indicating the kind of result produced by
     * PreparedStatement. The methods <code>
     * getResultSet</code> or
     * <code>getUpdateCount</code> are used to retrieve the first result,
     * while <code>getMoreResults</code> must be used to retrieve the second
     * and subsequent results.
     * 
     * @return true if the result of the execution is a ResultSet, false if
     *         there is no result or if the result is an update count.
     * @throws SQLException
     *             if a database error happens
     */
    public boolean execute() throws SQLException;

    /**
     * Execute the SQL query in the PreparedStatement and return the ResultSet
     * generated by the query.
     * 
     * @return the ResultSet generated by the query - never null.
     * @throws SQLException
     *             if a database error happens or if the SQL statement does not
     *             produce a ResultSet.
     */
    public ResultSet executeQuery() throws SQLException;

    /**
     * Invoke the SQL command contained within the Prepared Statement. This must
     * be INSERT, UPDATE, DELETE, or a command that returns nothing.
     * 
     * @return the count of rows for INSERT, UPDATE or DELETE statements, 0 for
     *         statements that return nothing
     * @throws SQLException
     *             if a database error happens or if the SQL statement returns a
     *             ResultSet.
     */
    public int executeUpdate() throws SQLException;

    /**
     * Returns a ResultSetMetaData containing data from the ResultSet that is
     * produced when the PreparedStatement is invoked.
     * <p>
     * It is possible to know the Metadata for the ResultSet without executing
     * the PreparedStatement, because the PreparedStatement is precompiled. As a
     * result the Metadata can be queried ahead of time without actually
     * executing the statement.
     * 
     * @return a ResultSetMetaData object with the information about the columns
     *         of the ResultSet, if the driver can return a ResultSetMetaData.
     *         null otherwise.
     * @throws SQLException
     *             if there is a database error
     */
    public ResultSetMetaData getMetaData() throws SQLException;

    /**
     * Gets information about the parameters of the PreparedStatement.
     * 
     * @return a ParameterMetaData object which holds information about the
     *         number, type and properties of the parameters of this
     *         PreparedStatement.
     * @throws SQLException
     *             if a database error happens
     */
    public ParameterMetaData getParameterMetaData() throws SQLException;

    /**
     * Sets the value of a specified parameter to the supplied Array object.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theArray
     *            a java.sql.Array holing the data to set.
     * @throws SQLException
     *             if a database error happens
     */
    public void setArray(int parameterIndex, Array theArray)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to the content of a supplied
     * InputStream, which has a specified number of bytes.
     * <p>
     * This is a good method for setting an SQL LONVARCHAR parameter where the
     * length of the data is large. Data is read from the InputStream until
     * end-of-file is reached or the specified number of bytes is copied.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theInputStream
     *            the ASCII InputStream carrying the data to update the
     *            parameter
     * @param length
     *            the number of bytes in the InputStream to copy to the
     *            parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setAsciiStream(int parameterIndex, InputStream theInputStream,
            int length) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied
     * java.math.BigDecimal value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theBigDecimal
     *            the java.math.BigInteger value to set
     * @throws SQLException
     *             if a database error happens
     */
    public void setBigDecimal(int parameterIndex, BigDecimal theBigDecimal)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to the content of a supplied
     * binary InputStream, which has a specified number of bytes.
     * <p>
     * Use this method when a large amount of data needs to be set into a
     * LONGVARBINARY parameter.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theInputStream
     *            the binary InputStream carrying the data to update the
     *            parameter
     * @param length
     *            the number of bytes in the InputStream to copy to the
     *            parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setBinaryStream(int parameterIndex, InputStream theInputStream,
            int length) throws SQLException;

    /**
     * Sets the value of a specified parameter to the given Blob object.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theBlob
     *            a java.sql.Blob holding the data to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setBlob(int parameterIndex, Blob theBlob) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied boolean value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theBoolean
     *            the boolean value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setBoolean(int parameterIndex, boolean theBoolean)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied byte value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theByte
     *            the byte value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setByte(int parameterIndex, byte theByte) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied array of bytes. The
     * array is mapped to a VARBINARY or LONGVARBINARY in the database.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theBytes
     *            the array of bytes to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setBytes(int parameterIndex, byte[] theBytes)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to the character content of a
     * Reader object, with the specified length of character data.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param reader
     *            the java.io.Reader encompassing the character data
     * @param length
     *            the amount of characters to be read
     * @throws SQLException
     *             if a database error happens
     */
    public void setCharacterStream(int parameterIndex, Reader reader, int length)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to the given Clob object.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theClob
     *            a java.sql.Clob holding the data to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setClob(int parameterIndex, Clob theClob) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.sql.Date
     * value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theDate
     *            a java.sql.Date to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setDate(int parameterIndex, Date theDate) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.sql.Date
     * value, using a supplied Calendar to map the Date. The Calendar allows the
     * application to control the timezone used to compute the SQL DATE in the
     * database - without the supplied Calendar, the driver uses the default
     * timezone of the Java virtual machine.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theDate
     *            a java.sql.Date to update the parameter
     * @param cal
     *            a Calendar to use to construct the SQL DATE value
     * @throws SQLException
     *             if a database error happens
     */
    public void setDate(int parameterIndex, Date theDate, Calendar cal)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied double value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theDouble
     *            the double value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setDouble(int parameterIndex, double theDouble)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to to a supplied float value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theFloat
     *            the float value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setFloat(int parameterIndex, float theFloat)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied int value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theInt
     *            the int value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setInt(int parameterIndex, int theInt) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied long value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theLong
     *            the long value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setLong(int parameterIndex, long theLong) throws SQLException;

    /**
     * Sets the value of a specified parameter to SQL NULL. Don't use this
     * version of setNull for User Defined Types or for REF type parameters.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param sqlType
     *            the SQL Type of the parameter, as defined in java.sql.Types
     * @throws SQLException
     *             if a database error happens
     */
    public void setNull(int parameterIndex, int sqlType) throws SQLException;

    /**
     * Sets the value of a specified parameter to SQL NULL. This version of
     * setNull should be used for User Defined Types (UDTs) and also REF types.
     * UDTs can be STRUCT, DISTINCT, JAVA_OBJECT and named array types.
     * <p>
     * Applications must provide the SQL Type code and also a fully qualified
     * SQL Type name when supplying a NULL UDT or REF. For a UDT, the type name
     * is the type name of the parameter itself, but for a REF parameter the
     * type name is the type name of the referenced type.
     * 
     * @param paramIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param sqlType
     *            the SQL Type of the parameter, as defined in java.sql.Types
     * @param typeName
     *            the fully qualified name of a UDT or REF type - ignored if the
     *            parameter is not a UDT.
     * @throws SQLException
     *             if a database error happens
     */
    public void setNull(int paramIndex, int sqlType, String typeName)
            throws SQLException;

    /**
     * Sets the value of a specified parameter using a supplied object.
     * <p>
     * There is a standard mapping from Java types to SQL types, defined in the
     * JDBC specification. The passed object is then transformed into the
     * appropriate SQL type, and then transferred to the database. setObject can
     * be used to pass abstract data types unique to the database, by using a
     * JDBC driver specific Java type. If the object's class implements the
     * interface SQLData, the JDBC driver calls <code>SQLData.writeSQL</code>
     * to write it to the SQL data stream. If the object's class implements Ref,
     * Blob, Clob, Struct, or Array, the driver passes it to the database as a
     * value of the corresponding SQL type.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theObject
     *            the Object containing the value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setObject(int parameterIndex, Object theObject)
            throws SQLException;

    /**
     * Sets the value of a specified parameter using a supplied object.
     * <p>
     * The Object is converted to the given targetSqlType before it is sent to
     * the database. If the object has a custom mapping (its class implements
     * the interface SQLData), the JDBC driver will call the method
     * SQLData.writeSQL to write it to the SQL data stream. If the object's
     * class implements Ref, Blob, Clob, Struct, or Array, the driver will pass
     * it to the database in the form of the relevant SQL type.
     * 
     * @param parameterIndex
     *            the parameter index, where the first parameter has index 1
     * @param theObject
     *            the Object containing the value to update the parameter
     * @param targetSqlType
     *            the SQL Type to send to the database, as defined in
     *            java.sql.Types
     * @throws SQLException
     *             if a database error happens
     */
    public void setObject(int parameterIndex, Object theObject,
            int targetSqlType) throws SQLException;

    /**
     * Sets the value of a specified parameter using a supplied object.
     * <p>
     * The Object is converted to the given targetSqlType before it is sent to
     * the database. If the object has a custom mapping (its class implements
     * the interface SQLData), the JDBC driver will call the method
     * SQLData.writeSQL to write it to the SQL data stream. If the object's
     * class implements Ref, Blob, Clob, Struct, or Array, the driver will pass
     * it to the database in the form of the relevant SQL type.
     * 
     * @param parameterIndex
     *            the parameter index, where the first parameter has index 1
     * @param theObject
     *            the Object containing the value to update the parameter
     * @param targetSqlType
     *            the SQL Type to send to the database, as defined in
     *            java.sql.Types
     * @param scale
     *            the number of digits after the decimal point - only applies to
     *            the types java.sql.Types.DECIMAL and java.sql.Types.NUMERIC -
     *            ignored for all other types.
     * @throws SQLException
     *             if a database error happens
     */
    public void setObject(int parameterIndex, Object theObject,
            int targetSqlType, int scale) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied REF(<structured-type>)
     * value. This is stored as an SQL REF.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theRef
     *            a java.sql.Ref value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setRef(int parameterIndex, Ref theRef) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied short value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theShort
     *            a short value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setShort(int parameterIndex, short theShort)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied String.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theString
     *            a String value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setString(int parameterIndex, String theString)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.sql.Time
     * value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theTime
     *            a java.sql.Time value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setTime(int parameterIndex, Time theTime) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.sql.Time
     * value, using a supplied Calendar.
     * <p>
     * The driver uses the supplied Calendar to create the SQL TIME value, which
     * allows it to use a custom timezone - otherwise the driver uses the
     * default timezone of the Java virtual machine.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theTime
     *            a java.sql.Time value to update the parameter
     * @param cal
     *            a Calendar to use to construct the SQL TIME value
     * @throws SQLException
     *             if a database error happens
     */
    public void setTime(int parameterIndex, Time theTime, Calendar cal)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.sql.Timestamp
     * value.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theTimestamp
     *            the java.sql.Timestamp value to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setTimestamp(int parameterIndex, Timestamp theTimestamp)
            throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.sql.Timestamp
     * value, using the supplied Calendar.
     * <p>
     * The driver uses the supplied Calendar to create the SQL TIMESTAMP value,
     * which allows it to use a custom timezone - otherwise the driver uses the
     * default timezone of the Java virtual machine.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theTimestamp
     *            the java.sql.Timestamp value to update the parameter
     * @param cal
     *            a Calendar to use to construct the SQL TIMESTAMP value
     * @throws SQLException
     *             if a database error happens
     */
    public void setTimestamp(int parameterIndex, Timestamp theTimestamp,
            Calendar cal) throws SQLException;

    /**
     * @deprecated Sets the value of a specified parameter to the characters
     *             from a supplied InputStream, with a specified number of
     *             bytes.
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theInputStream
     *            the InputStream with the character data to update the
     *            parameter
     * @param length
     *            the number of bytes to read from the InputStream
     * @throws SQLException
     *             if a database error happens
     */
    @Deprecated
    public void setUnicodeStream(int parameterIndex,
            InputStream theInputStream, int length) throws SQLException;

    /**
     * Sets the value of a specified parameter to a supplied java.net.URL.
     * 
     * @param parameterIndex
     *            the parameter number index, where the first parameter has
     *            index 1
     * @param theURL
     *            the URL to update the parameter
     * @throws SQLException
     *             if a database error happens
     */
    public void setURL(int parameterIndex, URL theURL) throws SQLException;
}
