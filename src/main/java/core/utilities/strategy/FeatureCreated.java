/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utilities.strategy;

import java.util.List;
import java.util.Map;

/**
 * Implements in feature created.
 */
public interface FeatureCreated {
    List<String> getValueField(Map<String, String> table);
    String getCurrentUrl();
    String getCreatedByTxt();
    String getNameCreatorTxt();
}
