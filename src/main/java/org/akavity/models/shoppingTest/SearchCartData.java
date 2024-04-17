package org.akavity.models.shoppingTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCartData {
    String product;
    int numberOfElements;
    String cartProduct;
}
