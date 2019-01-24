
package com.goget.di;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Dipali Shah on 24/1/19
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}

