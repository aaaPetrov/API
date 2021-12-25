package com.solvd.homework21;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import org.testng.annotations.Test;

public class GetUserMethod extends AbstractApiMethodV2 {

    public GetUserMethod() {
        super(null, "get/user/response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

}
