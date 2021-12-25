package com.solvd.homework21;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetRepositoryMethod extends AbstractApiMethodV2 {

    public GetRepositoryMethod(String repo) {
        super(null, "get/repository/response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("repo", repo);
    }

}
