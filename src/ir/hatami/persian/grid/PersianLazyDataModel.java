package ir.hatami.persian.grid;


import javax.faces.model.DataModel;
import java.io.Serializable;
import java.util.List;

/**
 * @Author : Hamed Hatami
 */

public abstract class PersianLazyDataModel<T> extends DataModel<T> implements Serializable {

    private Integer totalRowsCount;
    private Integer pageSize;
    private Integer currentPage;
    private List<T> data;
    private Integer rowIndex;
    private Integer numberOfPages;
    private String sortField;
    private Boolean sortOrder;


    public PersianLazyDataModel() {
        this.pageSize = 3;
        this.currentPage = 1;
        sortOrder = true;
    }


    public Integer getNumberOfPages() {
        if (this.numberOfPages == null) {
            this.numberOfPages = (int) Math.ceil(getTotalRowsCount() * 1d / pageSize);
            ;
        }
        return this.numberOfPages;
    }

    public Integer getTotalRowsCount() {
        if (this.totalRowsCount == null) {
            this.totalRowsCount = count();
        }
        return this.totalRowsCount;
    }

    public void setTotalRowsCount(Integer totalRowsCount) {
        this.totalRowsCount = totalRowsCount;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Boolean getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public Object getWrappedData() {
        if (this.data == null) {
            this.data = this.load((this.currentPage - 1) * this.pageSize, this.pageSize, this.sortField, this.sortOrder);
        }
        return this.data;
    }

    @Override
    public int getRowCount() {
        if (this.data == null) {
            return -1;
        }
        return this.data.size();
    }

    @Override
    public T getRowData() {
        return this.data.get(getRowCount());
    }

    @Override
    public int getRowIndex() {
        return this.rowIndex;
    }

    @Override
    public boolean isRowAvailable() {
        if (this.data == null) {
            return false;
        }
        return this.rowIndex >= 0 && this.rowIndex < this.data.size();
    }

    @Override
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setWrappedData(Object data) {
        this.data = (List<T>) data;
    }


    public abstract List<T> load(Integer first, Integer pageSize, String sortField, Boolean sortOrder);

    public abstract Integer count();

}
