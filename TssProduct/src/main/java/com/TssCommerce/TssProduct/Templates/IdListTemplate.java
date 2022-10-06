package com.TssCommerce.TssProduct.Templates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdListTemplate {
    List<Long> idList;
}
