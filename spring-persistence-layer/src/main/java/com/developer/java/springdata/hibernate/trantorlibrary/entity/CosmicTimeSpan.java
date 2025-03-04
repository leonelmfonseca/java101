package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import com.developer.java.springdata.hibernate.trantorlibrary.common.Era;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Embeddable
@Data
@NoArgsConstructor
public class CosmicTimeSpan {
    private Integer startYear;
    private Integer endYear;
    private Era era;
    
    public boolean isValid() {
        return startYear != null && endYear != null && era != null;
    }
}


