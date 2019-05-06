<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- START SIDEBAR-->
<nav class="page-sidebar" id="sidebar">
    <div id="sidebar-collapse">
        <div class="admin-block d-flex">
            <div>
                <img src="./assets/img/admin-avatar.png" width="45px" />
            </div>
            <div class="admin-info">
                <div class="font-strong">${sessionScope.user.name}&nbsp;</div><small>Musteri</small></div>
        </div>
        <ul class="side-menu metismenu">
            <li>
                <a href="addresses"><i class="sidebar-item-icon fa fa-envelope"></i>
                    <span class="nav-label">Xaricdeki Unvanlarim</span></a>
            </li>
            <li>
                <a href="orders"><i class="sidebar-item-icon fa fa-calendar"></i>
                    <span class="nav-label">Sifarislerim</span>
                </a>
            </li>
            <li>
                <a href="balance"><i class="sidebar-item-icon fa fa-file-text"></i>
                    <span class="nav-label">Balans</span></a>
            </li>
            <li>
                <a href="messages"><i class="sidebar-item-icon fa fa-sitemap"></i>
                    <span class="nav-label">Mesajlarim</span></a>
            </li>
            <li>
                <a href="declarations"><i class="sidebar-item-icon fa fa-sitemap"></i>
                    <span class="nav-label">Beyannamelerim</span></a>
            </li>
            <li>
                <a href="javascript:;"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Tenzimlemeler</span><i class="fa fa-angle-left arrow"></i></a>
                <ul class="nav-2-level collapse">
                    <li>
                        <a href="profile">Profil</a>
                    </li>
                    <li>
                        <a href="change-password">Sifreni deyis</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<!-- END SIDEBAR-->