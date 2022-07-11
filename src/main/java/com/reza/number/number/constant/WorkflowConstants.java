package com.reza.number.number.constant;
import java.util.Map;

public abstract class WorkflowConstants {
    private WorkflowConstants() {}

    public static final String NUMBER_ID_VARIABLE_KEY = "numberId";
    public static final String WORKFLOW_CHOOSE_TYPE_PASS = "chooseTypePass";

    public static final Map<Long, String> PRODUCT_TO_WORKFLOW_MAP = Map.of(1L, "NUMBER");
}
