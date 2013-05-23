/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.organization;

import org.exoplatform.container.component.BaseComponentPlugin;

/**
 * If the other service or a third party want to customize their code to handle
 * a group event, the event can be new , update or remove. They should make a
 * class that extends from this class and register the listener with the
 * organization service. There are 2 ways to register a listener with the
 * service. a) To do it programatically: [..] import
 * org.exoplatform.container.PortalContainer ; import
 * org.exoplatform.services.organization.OrganizationService ; [..]
 * GroupEventListener listener = new MyGroupEventListener(..) ; PortalContainer
 * pcontainer = PortalContainer.getInstance() ; OrganizationService service =
 * (OrganizationService) pcontainer.getInstanceOfType(OrganizationService.class)
 * ; service.getGroupHandler().addGroupEventListener(listener) ; b) Register by
 * the xml configuration: You need to create a my.package.MyGroupEventListener
 * that extends this class and add a conf/portal/configuration.xml to the
 * classpath. The configuration.xml can be in a jar file. The file should
 * contain the following configuraiton:
 * 
 * <pre>
 * &lt;configuration&gt;
 *   [..]
 *   &lt;external-component-plugins&gt;
 *     &lt;target-component&gt;org.exoplatform.services.organization.OrganizationService&lt;/target-component&gt;
 *     &lt;component-plugin&gt;
 *        &lt;name&gt;my.group.listener&lt;/name&gt;
 *        &lt;set-method&gt;addListenerPlugin&lt;/set-method&gt;
 *        &lt;type&gt;my.package.MyGroupEventListener&lt;/type&gt;
 *        &lt;description&gt;your listener description&lt;/description&gt;
 *      &lt;/component-plugin&gt;
 *  &lt;/external-component-plugins&gt;
 *  [...]
 * /configuration&gt;
 * </pre>
 * @author <a href="mailto:tuan08@groups.sourceforge.net">Tuan Nguyen</a>
 * @LevelAPI Platform
 */
public class GroupEventListener extends BaseComponentPlugin
{
   /**
    * This method is called before the group is persisted to the database.
    * 
    * @param group The group to be saved
    * @param isNew if the group is a new record in the database or not
    * @throws Exception The developer can decide to throw an exception or not. If
    *           the listener throw an exception, the organization service should
    *           not save/update the group to the database
    */
   public void preSave(Group group, boolean isNew) throws Exception
   {
   }

   /**
    * This method is called after the group has been saved but not commited yet
    * 
    * @param group The group has been saved.
    * @param isNew if the group is a new record in the database or not
    * @throws Exception The developer can decide to throw the exception or not.
    *           If the method throw an exception. The organization service should
    *           role back the data to the state before the method
    *           GroupHandler.addChild(..) or GroupHandler.saveGroup(..) is
    *           called.
    */
   public void postSave(Group group, boolean isNew) throws Exception
   {
   }

   /**
    * This method is called before a group should be deleted
    * 
    * @param group the group to be delete
    * @throws Exception The developer can decide to throw the exception or not.
    *           If the method throw an exception. The organization service should
    *           not remove the group record from the database.
    */
   public void preDelete(Group group) throws Exception
   {
   }

   /**
    * This method should be called after the group has been removed from the
    * database but not commited yet.
    * 
    * @param group The group has been removed.
    * @throws Exception The developer can decide to throw the exception or not.
    *           If the method throw the exception, the organization service
    *           should role back the database to the state before the method
    *           GroupHandler.removeGroup(..) is called.
    */
   public void postDelete(Group group) throws Exception
   {
   }
}
