package com.parse.steam.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDto {
    private Long id;
    private String name;
    private Integer nits;
    private Integer diagonal;
    private Integer hz;
    private Integer gtg;
    private Integer hdmi;
    private Integer dp;
    private Integer vga;
    private SizeDto size;
    private BrandDto brand;
    private MatrixDto matrix;
    private Boolean archived;
}
