/*
 * Copyright (C) 2017 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.prjdagger2.datasource.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

import es.voghdev.prjdagger2.global.model.User;

public class UserDBEntry extends BaseModel {
    @PrimaryKey
    @Column
    String id;
    @Column
    String name;
    @Column
    String address;
    @Column
    String username;
    @Column
    String thumbnail;
    @Column
    String facebookId;
    @Column
    String email;

    public UserDBEntry() {
        // Mandatory for DBFlow to work
    }

    public UserDBEntry(User user) {
        id = user.getId();
        name = user.getName();
        address = user.getAddress();
        username = user.getUsername();
        thumbnail = user.getThumbnail();
        facebookId = user.getFacebookId();
        email = user.getEmail();
    }

    public User parseUser() {
        User obj = new User();
        obj.setId(id);
        obj.setName(name);
        obj.setAddress(address);
        obj.setUsername(username);
        obj.setThumbnail(thumbnail);
        obj.setFacebookId(facebookId);
        obj.setEmail(email);
        return obj;
    }
}
