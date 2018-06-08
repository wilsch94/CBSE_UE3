package cbse.ue3.products.data;


public class Finishing Product extends Product{
        private FinishingType finishingType;

        public FinishignProduct(String name, double price, FinishingType finishingType){
                super(name, price);

                this.finishingType = finishingType;
        }
        
        public FinishingType getFinishingType() {
                return finishingType;
        }

        public void setFinishingType(FinishingType finishingType) {
                this.finishingType = finishingType;
        }
