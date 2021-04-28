package sample.JPA;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Product_catalog")
public class ProductCatalog {

        @Id
        @Column(name = "id")
        @GeneratedValue(generator = "incrementation")
        @GenericGenerator(name = "incrementation", strategy = "increment")
        private int id;
        @Column(name = "catalog_no")
        private int catalogNo;
        @Column(name = "symbol")
        private String symbol;
        @Column(name = "price_net")
        private double priceNet;
        @Column(name = "stock")
        private int stock;
        //@ManyToOne(targetEntity = Categories.class, fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
        //@JoinColumn(name = "group_id", referencedColumnName = "id")
        @Column(name = "group_id")
        private int groupId;


    public ProductCatalog(int id, int catalogNo, String symbol, double priceNet, int stock, int groupId) {
        this.id = id;
        this.catalogNo = catalogNo;
        this.symbol = symbol;
        this.priceNet = priceNet;
        this.stock = stock;
        this.groupId = groupId;
    }

    public ProductCatalog(int catalogNo, String symbol, double priceNet, int stock, int groupId) {
        this.catalogNo = catalogNo;
        this.symbol = symbol;
        this.priceNet = priceNet;
        this.stock = stock;
        this.groupId = groupId;
    }

    public ProductCatalog() {
    }

        public int getCatalogNo() {
            return catalogNo;
        }

        public void setCatalogNo(int catalogNo) {
            this.catalogNo = catalogNo;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public double getPriceNet() {
            return priceNet;
        }

        public void setPriceNet(double priceNet) {
            this.priceNet = priceNet;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductCatalog" +
                "id=" + id +
                "catalogNo=" + catalogNo +
                ", symbol='" + symbol + '\'' +
                ", priceNet=" + priceNet +
                ", stock=" + stock +
                ", groupId=" + groupId;
    }
}

