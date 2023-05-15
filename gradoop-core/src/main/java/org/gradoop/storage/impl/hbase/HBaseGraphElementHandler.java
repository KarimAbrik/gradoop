/*
 * This file is part of Gradoop.
 *
 * Gradoop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Gradoop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Gradoop.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.gradoop.storage.impl.hbase;

import com.google.common.collect.Sets;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.Writables;
import org.gradoop.model.impl.id.GradoopId;
import org.gradoop.model.impl.id.GradoopIds;
import org.gradoop.util.GConstants;
import org.gradoop.model.api.EPGMGraphElement;
import org.gradoop.storage.api.GraphElementHandler;

import java.io.IOException;
import java.util.Set;

/**
 * Handler class for entities that are contained in logical graphs (i.e.,
 * vertex and edge data).
 */
public abstract class HBaseGraphElementHandler extends
  HBaseElementHandler implements GraphElementHandler {
  /**
   * Byte representation of the graphs column identifier.
   */
  private static final byte[] COL_GRAPHS_BYTES =
    Bytes.toBytes(GConstants.COL_GRAPHS);

  /**
   * {@inheritDoc}
   */
  @Override
  public Put writeGraphIds(Put put, EPGMGraphElement graphElement) throws
    IOException {

    if (graphElement.getGraphCount() > 0) {
      byte[] graphsBytes = Writables.getBytes(graphElement.getGraphIds());
      put = put.add(CF_META_BYTES, COL_GRAPHS_BYTES, graphsBytes);
    }

    return put;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GradoopIds readGraphIds(Result res) throws IOException {
    byte[] graphBytes = res.getValue(CF_META_BYTES, COL_GRAPHS_BYTES);
    
    GradoopIds graphIds = null;
    Writables.getWritable(graphBytes, graphIds);

    return graphIds;
  }
}
