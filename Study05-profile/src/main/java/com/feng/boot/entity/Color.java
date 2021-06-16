package com.feng.boot.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Data
@Builder
public class Color {
    private String color;
}
