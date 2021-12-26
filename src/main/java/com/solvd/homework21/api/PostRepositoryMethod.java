package com.solvd.homework21.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostRepositoryMethod extends AbstractApiMethodV2 {

    public PostRepositoryMethod() {
        super("post/request.json", "post/response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

}
