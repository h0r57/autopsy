/*
 * Autopsy Forensic Browser
 *
 * Copyright 2015 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.events;

import java.io.Serializable;
import org.sleuthkit.autopsy.casemodule.Case;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.datamodel.BlackboardArtifactTag;
import org.sleuthkit.datamodel.TskCoreException;

/**
 *
 */
public class BlackBoardArtifactTagAddedEvent extends TagAddedEvent<BlackboardArtifactTag> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ContentTagAddedEvent.class.getName());

    private transient BlackboardArtifactTag tag;
    private final long tagID;

    public BlackBoardArtifactTagAddedEvent(BlackboardArtifactTag newTag) {
        super(Case.Events.BLACKBOARD_ARTIFACT_TAG_ADDED.toString(), newTag
        );
        tagID = newTag.getId();
    }

    @Override
    BlackboardArtifactTag getTagByID(long id) throws IllegalStateException, TskCoreException {
        return Case.getCurrentCase().getServices().getTagsManager().getBlackboardArtifactTagByTagID(tagID);
    }

}
