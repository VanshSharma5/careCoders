package com._1shhub.carecoders.dto.addres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pinCode;
}
