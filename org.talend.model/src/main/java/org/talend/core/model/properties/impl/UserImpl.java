/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.core.model.properties.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.core.model.properties.DashboardConnection;
import org.talend.core.model.properties.Project;
import org.talend.core.model.properties.PropertiesPackage;
import org.talend.core.model.properties.User;
import org.talend.core.model.properties.UserModuleAuthorization;
import org.talend.core.model.properties.UserProjectAuthorization;
import org.talend.core.model.properties.UserRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getLogin <em>Login</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getDeleteDate <em>Delete Date</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#isAllowedToModifyComponents <em>Allowed To Modify Components</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getProjectAuthorization <em>Project Authorization</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getModuleAuthorization <em>Module Authorization</em>}</li>
 *   <li>{@link org.talend.core.model.properties.impl.UserImpl#getPreferredDashboardConnection <em>Preferred Dashboard Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected static final String LOGIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected String login = LOGIN_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final byte[] PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected byte[] password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstName()
     * @generated
     * @ordered
     */
    protected static final String FIRST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstName()
     * @generated
     * @ordered
     */
    protected String firstName = FIRST_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastName()
     * @generated
     * @ordered
     */
    protected static final String LAST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastName()
     * @generated
     * @ordered
     */
    protected String lastName = LAST_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final Date CREATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected Date creationDate = CREATION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getDeleteDate() <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteDate()
     * @generated
     * @ordered
     */
    protected static final Date DELETE_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDeleteDate() <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteDate()
     * @generated
     * @ordered
     */
    protected Date deleteDate = DELETE_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected static final boolean DELETED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected boolean deleted = DELETED_EDEFAULT;

    /**
     * The default value of the '{@link #isAllowedToModifyComponents() <em>Allowed To Modify Components</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllowedToModifyComponents()
     * @generated
     * @ordered
     */
    protected static final boolean ALLOWED_TO_MODIFY_COMPONENTS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAllowedToModifyComponents() <em>Allowed To Modify Components</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllowedToModifyComponents()
     * @generated
     * @ordered
     */
    protected boolean allowedToModifyComponents = ALLOWED_TO_MODIFY_COMPONENTS_EDEFAULT;

    /**
     * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComment()
     * @generated
     * @ordered
     */
    protected static final String COMMENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComment()
     * @generated
     * @ordered
     */
    protected String comment = COMMENT_EDEFAULT;

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected UserRole role;

    /**
     * The cached value of the '{@link #getProjectAuthorization() <em>Project Authorization</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProjectAuthorization()
     * @generated
     * @ordered
     */
    protected EList projectAuthorization;

    /**
     * The cached value of the '{@link #getModuleAuthorization() <em>Module Authorization</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModuleAuthorization()
     * @generated
     * @ordered
     */
    protected EList moduleAuthorization;

    /**
     * The cached value of the '{@link #getPreferredDashboardConnection() <em>Preferred Dashboard Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPreferredDashboardConnection()
     * @generated
     * @ordered
     */
    protected DashboardConnection preferredDashboardConnection;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return PropertiesPackage.Literals.USER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLogin() {
        return login;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLogin(String newLogin) {
        String oldLogin = login;
        login = newLogin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__LOGIN, oldLogin, login));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassword(byte[] newPassword) {
        byte[] oldPassword = password;
        password = newPassword;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__PASSWORD, oldPassword, password));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFirstName(String newFirstName) {
        String oldFirstName = firstName;
        firstName = newFirstName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__FIRST_NAME, oldFirstName, firstName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLastName(String newLastName) {
        String oldLastName = lastName;
        lastName = newLastName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__LAST_NAME, oldLastName, lastName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCreationDate(Date newCreationDate) {
        Date oldCreationDate = creationDate;
        creationDate = newCreationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__CREATION_DATE, oldCreationDate, creationDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getDeleteDate() {
        return deleteDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleteDate(Date newDeleteDate) {
        Date oldDeleteDate = deleteDate;
        deleteDate = newDeleteDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__DELETE_DATE, oldDeleteDate, deleteDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleted(boolean newDeleted) {
        boolean oldDeleted = deleted;
        deleted = newDeleted;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__DELETED, oldDeleted, deleted));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAllowedToModifyComponents() {
        return allowedToModifyComponents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAllowedToModifyComponents(boolean newAllowedToModifyComponents) {
        boolean oldAllowedToModifyComponents = allowedToModifyComponents;
        allowedToModifyComponents = newAllowedToModifyComponents;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__ALLOWED_TO_MODIFY_COMPONENTS, oldAllowedToModifyComponents, allowedToModifyComponents));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getComment() {
        return comment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComment(String newComment) {
        String oldComment = comment;
        comment = newComment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__COMMENT, oldComment, comment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserRole getRole() {
        if (role != null && role.eIsProxy()) {
            InternalEObject oldRole = (InternalEObject)role;
            role = (UserRole)eResolveProxy(oldRole);
            if (role != oldRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesPackage.USER__ROLE, oldRole, role));
            }
        }
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserRole basicGetRole() {
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRole(UserRole newRole) {
        UserRole oldRole = role;
        role = newRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__ROLE, oldRole, role));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getProjectAuthorization() {
        if (projectAuthorization == null) {
            projectAuthorization = new EObjectWithInverseResolvingEList(UserProjectAuthorization.class, this, PropertiesPackage.USER__PROJECT_AUTHORIZATION, PropertiesPackage.USER_PROJECT_AUTHORIZATION__USER);
        }
        return projectAuthorization;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getModuleAuthorization() {
        if (moduleAuthorization == null) {
            moduleAuthorization = new EObjectWithInverseResolvingEList(UserModuleAuthorization.class, this, PropertiesPackage.USER__MODULE_AUTHORIZATION, PropertiesPackage.USER_MODULE_AUTHORIZATION__USER);
        }
        return moduleAuthorization;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DashboardConnection getPreferredDashboardConnection() {
        if (preferredDashboardConnection != null && preferredDashboardConnection.eIsProxy()) {
            InternalEObject oldPreferredDashboardConnection = (InternalEObject)preferredDashboardConnection;
            preferredDashboardConnection = (DashboardConnection)eResolveProxy(oldPreferredDashboardConnection);
            if (preferredDashboardConnection != oldPreferredDashboardConnection) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesPackage.USER__PREFERRED_DASHBOARD_CONNECTION, oldPreferredDashboardConnection, preferredDashboardConnection));
            }
        }
        return preferredDashboardConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DashboardConnection basicGetPreferredDashboardConnection() {
        return preferredDashboardConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPreferredDashboardConnection(DashboardConnection newPreferredDashboardConnection) {
        DashboardConnection oldPreferredDashboardConnection = preferredDashboardConnection;
        preferredDashboardConnection = newPreferredDashboardConnection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.USER__PREFERRED_DASHBOARD_CONNECTION, oldPreferredDashboardConnection, preferredDashboardConnection));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PropertiesPackage.USER__PROJECT_AUTHORIZATION:
                return ((InternalEList)getProjectAuthorization()).basicAdd(otherEnd, msgs);
            case PropertiesPackage.USER__MODULE_AUTHORIZATION:
                return ((InternalEList)getModuleAuthorization()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PropertiesPackage.USER__PROJECT_AUTHORIZATION:
                return ((InternalEList)getProjectAuthorization()).basicRemove(otherEnd, msgs);
            case PropertiesPackage.USER__MODULE_AUTHORIZATION:
                return ((InternalEList)getModuleAuthorization()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PropertiesPackage.USER__ID:
                return new Integer(getId());
            case PropertiesPackage.USER__LOGIN:
                return getLogin();
            case PropertiesPackage.USER__PASSWORD:
                return getPassword();
            case PropertiesPackage.USER__FIRST_NAME:
                return getFirstName();
            case PropertiesPackage.USER__LAST_NAME:
                return getLastName();
            case PropertiesPackage.USER__CREATION_DATE:
                return getCreationDate();
            case PropertiesPackage.USER__DELETE_DATE:
                return getDeleteDate();
            case PropertiesPackage.USER__DELETED:
                return isDeleted() ? Boolean.TRUE : Boolean.FALSE;
            case PropertiesPackage.USER__ALLOWED_TO_MODIFY_COMPONENTS:
                return isAllowedToModifyComponents() ? Boolean.TRUE : Boolean.FALSE;
            case PropertiesPackage.USER__COMMENT:
                return getComment();
            case PropertiesPackage.USER__ROLE:
                if (resolve) return getRole();
                return basicGetRole();
            case PropertiesPackage.USER__PROJECT_AUTHORIZATION:
                return getProjectAuthorization();
            case PropertiesPackage.USER__MODULE_AUTHORIZATION:
                return getModuleAuthorization();
            case PropertiesPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
                if (resolve) return getPreferredDashboardConnection();
                return basicGetPreferredDashboardConnection();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PropertiesPackage.USER__ID:
                setId(((Integer)newValue).intValue());
                return;
            case PropertiesPackage.USER__LOGIN:
                setLogin((String)newValue);
                return;
            case PropertiesPackage.USER__PASSWORD:
                setPassword((byte[])newValue);
                return;
            case PropertiesPackage.USER__FIRST_NAME:
                setFirstName((String)newValue);
                return;
            case PropertiesPackage.USER__LAST_NAME:
                setLastName((String)newValue);
                return;
            case PropertiesPackage.USER__CREATION_DATE:
                setCreationDate((Date)newValue);
                return;
            case PropertiesPackage.USER__DELETE_DATE:
                setDeleteDate((Date)newValue);
                return;
            case PropertiesPackage.USER__DELETED:
                setDeleted(((Boolean)newValue).booleanValue());
                return;
            case PropertiesPackage.USER__ALLOWED_TO_MODIFY_COMPONENTS:
                setAllowedToModifyComponents(((Boolean)newValue).booleanValue());
                return;
            case PropertiesPackage.USER__COMMENT:
                setComment((String)newValue);
                return;
            case PropertiesPackage.USER__ROLE:
                setRole((UserRole)newValue);
                return;
            case PropertiesPackage.USER__PROJECT_AUTHORIZATION:
                getProjectAuthorization().clear();
                getProjectAuthorization().addAll((Collection)newValue);
                return;
            case PropertiesPackage.USER__MODULE_AUTHORIZATION:
                getModuleAuthorization().clear();
                getModuleAuthorization().addAll((Collection)newValue);
                return;
            case PropertiesPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
                setPreferredDashboardConnection((DashboardConnection)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(int featureID) {
        switch (featureID) {
            case PropertiesPackage.USER__ID:
                setId(ID_EDEFAULT);
                return;
            case PropertiesPackage.USER__LOGIN:
                setLogin(LOGIN_EDEFAULT);
                return;
            case PropertiesPackage.USER__PASSWORD:
                setPassword(PASSWORD_EDEFAULT);
                return;
            case PropertiesPackage.USER__FIRST_NAME:
                setFirstName(FIRST_NAME_EDEFAULT);
                return;
            case PropertiesPackage.USER__LAST_NAME:
                setLastName(LAST_NAME_EDEFAULT);
                return;
            case PropertiesPackage.USER__CREATION_DATE:
                setCreationDate(CREATION_DATE_EDEFAULT);
                return;
            case PropertiesPackage.USER__DELETE_DATE:
                setDeleteDate(DELETE_DATE_EDEFAULT);
                return;
            case PropertiesPackage.USER__DELETED:
                setDeleted(DELETED_EDEFAULT);
                return;
            case PropertiesPackage.USER__ALLOWED_TO_MODIFY_COMPONENTS:
                setAllowedToModifyComponents(ALLOWED_TO_MODIFY_COMPONENTS_EDEFAULT);
                return;
            case PropertiesPackage.USER__COMMENT:
                setComment(COMMENT_EDEFAULT);
                return;
            case PropertiesPackage.USER__ROLE:
                setRole((UserRole)null);
                return;
            case PropertiesPackage.USER__PROJECT_AUTHORIZATION:
                getProjectAuthorization().clear();
                return;
            case PropertiesPackage.USER__MODULE_AUTHORIZATION:
                getModuleAuthorization().clear();
                return;
            case PropertiesPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
                setPreferredDashboardConnection((DashboardConnection)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case PropertiesPackage.USER__ID:
                return id != ID_EDEFAULT;
            case PropertiesPackage.USER__LOGIN:
                return LOGIN_EDEFAULT == null ? login != null : !LOGIN_EDEFAULT.equals(login);
            case PropertiesPackage.USER__PASSWORD:
                return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
            case PropertiesPackage.USER__FIRST_NAME:
                return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
            case PropertiesPackage.USER__LAST_NAME:
                return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
            case PropertiesPackage.USER__CREATION_DATE:
                return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
            case PropertiesPackage.USER__DELETE_DATE:
                return DELETE_DATE_EDEFAULT == null ? deleteDate != null : !DELETE_DATE_EDEFAULT.equals(deleteDate);
            case PropertiesPackage.USER__DELETED:
                return deleted != DELETED_EDEFAULT;
            case PropertiesPackage.USER__ALLOWED_TO_MODIFY_COMPONENTS:
                return allowedToModifyComponents != ALLOWED_TO_MODIFY_COMPONENTS_EDEFAULT;
            case PropertiesPackage.USER__COMMENT:
                return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
            case PropertiesPackage.USER__ROLE:
                return role != null;
            case PropertiesPackage.USER__PROJECT_AUTHORIZATION:
                return projectAuthorization != null && !projectAuthorization.isEmpty();
            case PropertiesPackage.USER__MODULE_AUTHORIZATION:
                return moduleAuthorization != null && !moduleAuthorization.isEmpty();
            case PropertiesPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
                return preferredDashboardConnection != null;
        }
        return super.eIsSet(featureID);
    }

    public String toString() {
        if (firstName != null && lastName != null)
            return lastName + ", " + firstName; //$NON-NLS-1$

        return login;
    }

} //UserImpl