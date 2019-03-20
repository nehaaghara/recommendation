<%-- 
    Document   : adminMenu
    Created on : Mar 6, 2019, 10:58:24 AM
    Author     : ITMCS
--%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.servletContext.contextPath}/webresource/admin/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.UserSession.userName}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                    </button>
                </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i> <span>User</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.servletContext.contextPath}/loginindex"><i class="fa fa-circle-o"></i>Login</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/registrationindex"><i class="fa fa-circle-o"></i>Register</a></li>
                </ul>
            </li>

           <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i> <span>Branch</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.servletContext.contextPath}/addBranch"><i class="fa fa-circle-o"></i>Add Branch</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/viewbranch"><i class="fa fa-circle-o"></i>view Branch</a></li>
                </ul>
            </li>

           
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i>
                    <span>Institute</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.servletContext.contextPath}/addinstitute"><i class="fa fa-circle-o"></i> Add Institute</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/viewinstitute"><i class="fa fa-circle-o"></i>View Institute</a></li>

                </ul>
            </li>
            
             <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i> <span>Institute Branch</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.servletContext.contextPath}/addinstitutebranch"><i class="fa fa-circle-o"></i>Add Institute Branch</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/viewinstitutebranch"><i class="fa fa-circle-o"></i>view Institute Branch</a></li>
                </ul>
            </li>

        </ul>
    </section>
</aside> 




