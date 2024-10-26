package com.born.list_share.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsToGetEntity {
    private Integer id;
    private String name;
    private String amount;
}
