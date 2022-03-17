
package alf.api.web.modelRequest;

import alf.api.web.models.ItemMoveSearcher;

public class ItemMoveRequest {
    private PageInfo pageInfo;
    private ItemMoveSearcher itemMoveSearcher;

    public ItemMoveRequest(PageInfo pageInfo, ItemMoveSearcher itemMoveSearcher) {
        this.pageInfo = pageInfo;
        this.itemMoveSearcher = itemMoveSearcher;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ItemMoveSearcher getItemMoveSearcher() {
        return itemMoveSearcher;
    }

    public void setItemMove(ItemMoveSearcher itemMoveSearcher) {
        this.itemMoveSearcher = itemMoveSearcher;
    }

    @Override
    public String toString() {
        return "ItemMoveRequest [itemMoveSearcher=" + itemMoveSearcher + ", pageInfo=" + pageInfo + "]";
    }

}