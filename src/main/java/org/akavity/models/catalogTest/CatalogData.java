package org.akavity.models.catalogTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogData {
    String chapterItem;
    String categoryItem;
    String expectedTitle;
}
