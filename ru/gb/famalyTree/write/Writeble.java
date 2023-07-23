package ru.gb.famalyTree;

import java.io.Serializable;
import java.util.Objects;

public interface Writeble {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
