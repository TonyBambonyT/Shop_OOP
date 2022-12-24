package Store;

import Store.Products.*;

public enum ProductType {
    MeatProducts,
    BakeryProducts,
    DairyProducts,
    VegetablesFruits,
    HouseholdProducts,
    GroceryProducts,
    AlcoholicProducts,
    CigaretteProducts;

    /**
     * transform enum value to class
     * @return class corresponding to value
     */
    public Class<? extends Product> toClass() {
        return switch (this) {
            case MeatProducts -> MeatProducts.class;
            case BakeryProducts -> BakeryProducts.class;
            case DairyProducts -> DairyProducts.class;
            case VegetablesFruits -> VegetablesFruits.class;
            case HouseholdProducts -> HouseholdProducts.class;
            case GroceryProducts -> GroceryProducts.class;
            case AlcoholicProducts -> AlcoholicProducts.class;
            case CigaretteProducts -> CigaretteProducts.class;
        };
    }
}
