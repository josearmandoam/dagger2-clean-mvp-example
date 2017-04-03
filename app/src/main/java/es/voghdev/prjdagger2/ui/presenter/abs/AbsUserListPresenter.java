/*
 * Copyright (C) 2015 Olmo Gallegos Hernández.
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
package es.voghdev.prjdagger2.ui.presenter.abs;

import java.util.List;

import es.voghdev.prjdagger2.global.model.User;
import es.voghdev.prjdagger2.ui.presenter.Presenter;

public abstract class AbsUserListPresenter extends Presenter<AbsUserListPresenter.View,
        AbsUserListPresenter.Navigator> {

    public abstract void onUserPictureClicked(User user);

    public abstract void onUserRowClicked(User user);

    public interface View {
        void showUserList(List<User> users);

        void showUserListError(Exception e);

        void showNoInternetMessage();

        void showLoading();

        void hideLoading();

        void makeUserSayHello(User user);

        void showUserClickedMessage(User user);

    }

    public interface Navigator {
        void showUserDetailScreen(User user);
    }
}
