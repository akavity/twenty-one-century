package org.akavity.models.shoppingTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensiveFilterData {
    String title;
    String name;
    String text;
    int price;
    int elements;
}
