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
package org.exoplatform.services.document.test;

import org.exoplatform.services.document.impl.DocumentReaderServiceImpl;
import org.exoplatform.services.document.impl.OpenOfficeDocumentReader;

import java.io.InputStream;

/**
 * Created by The eXo Platform SAS Author : Sergey Karpenko
 * <sergey.karpenko@exoplatform.com.ua>
 * 
 * @version $Id: $
 */

public class TestOpenOfficeDocumentReader extends BaseStandaloneTest
{
   DocumentReaderServiceImpl service;

   @Override
   public void setUp() throws Exception
   {
      super.setUp();
      service = new DocumentReaderServiceImpl(null);
      service.addDocumentReader(new OpenOfficeDocumentReader());
   }

   public void testGetContentAsString() throws Exception
   {
      InputStream is = TestOpenOfficeDocumentReader.class.getResourceAsStream("/test.odt");
      try
      {
         String text = service.getDocumentReader("application/vnd.oasis.opendocument.text").getContentAsText(is);

         String expected = "This is a test Open Office document `1234567890-= !@#$%^&*()_+~|:?><|\\,./[]{}";

         assertEquals("Wrong string returned", normalizeWhitespaces(expected), normalizeWhitespaces(text));
      }
      finally
      {
         is.close();
      }
   }
}
