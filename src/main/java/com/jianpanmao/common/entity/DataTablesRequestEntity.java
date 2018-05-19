package com.jianpanmao.common.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */
public class DataTablesRequestEntity {


    /* Draw counter. This is used by DataTables to ensure that the Ajax returns from server-side processing requests are drawn in sequence by DataTables
    (Ajax requests are asynchronous and thus can return out of sequence). This is used as part of the draw return parameter (see below).
            */
    private int draw;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    /**
     * Paging first record indicator. This is the start point in the current data set (0 index based - i.e. 0 is the first record).
     */
    private int start;

    /**
     * Number of records that the table can display in the current draw. It is expected that the number of records returned will be equal to this number, unless
     * the server has fewer records to return. Note that this can be -1 to indicate that all records should be returned (although that negates any benefits of
     * server-side processing!)
     */
    private int length;

    /**
     * @see Search
     */
    private Search search;

    /**
     * @see Order
     */
    private List<Order> order;

    /**
     * @see Column
     */
    private List<Column> columns;


    private static class Search {
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isRegex() {
            return regex;
        }

        public void setRegex(boolean regex) {
            this.regex = regex;
        }

        /**
         * Global search value. To be applied to all columns which have searchable as true.
         */
        private String value;

        /**
         * <code>true</code> if the global filter should be treated as a regular expression for advanced searching, false otherwise. Note that normally server-side
         * processing scripts will not perform regular expression searching for performance reasons on large data sets, but it is technically possible and at the
         * discretion of your script.
         */
        private boolean regex;
    }

    public static class Order {
        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        /**
         * Column to which ordering should be applied. This is an index reference to the columns array of information that is also submitted to the server.
         */
        private int column;

        /**
         * Ordering direction for this column. It will be <code>asc</code> or <code>desc</code> to indicate ascending ordering or descending ordering,
         * respectively.
         */
        private String dir;
    }


    private static class Column {
        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSearchable() {
            return searchable;
        }

        public void setSearchable(boolean searchable) {
            this.searchable = searchable;
        }

        public boolean isOrderable() {
            return orderable;
        }

        public void setOrderable(boolean orderable) {
            this.orderable = orderable;
        }

        public Search getSearch() {
            return search;
        }

        public void setSearch(Search search) {
            this.search = search;
        }

        public boolean isRegex() {
            return regex;
        }

        public void setRegex(boolean regex) {
            this.regex = regex;
        }

        /**
         * Column's data source, as defined by columns.data.
         */
        private String data;

        /**
         * Column's name, as defined by columns.name.
         */
        private String name;

        /**
         * Flag to indicate if this column is searchable (true) or not (false). This is controlled by columns.searchable.
         */
        private boolean searchable;


        /**
         * Flag to indicate if this column is orderable (true) or not (false). This is controlled by columns.orderable.
         */
        private boolean orderable;

        /**
         * Search value to apply to this specific column.
         */
        private Search search;

        /**
         * Flag to indicate if the search term for this column should be treated as regular expression (true) or not (false). As with global search, normally
         * server-side processing scripts will not perform regular expression searching for performance reasons on large data sets, but it is technically possible
         * and at the discretion of your script.
         */
        private boolean regex;
    }

}